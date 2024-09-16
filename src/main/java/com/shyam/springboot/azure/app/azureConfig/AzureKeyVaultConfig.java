package com.shyam.springboot.azure.app.azureConfig;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.keys.KeyClient;
import com.azure.security.keyvault.keys.KeyClientBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Profile("!local")
@Configuration
@EnableConfigurationProperties
public class AzureKeyVaultConfig {

    @Value("${azure.keyvault.uri}")
    private final String keyVaultUri;

    @Value("${azure.storage.account-name}")
    private final String storageAccountName;

    public AzureKeyVaultConfig(String keyVaultUri, String storageAccountName) {
        this.keyVaultUri = keyVaultUri;
        this.storageAccountName = storageAccountName;
    }

    @Bean
    public SecretClient secretClient() {
        return new SecretClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

    @Bean
    public KeyClient keyClient() {
        return new KeyClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

    @Bean
    public DataSource dataSource(SecretClient secretClient) {
        String jdbcUrl = secretClient.getSecret("jdbc-url").getValue();
        String username = secretClient.getSecret("db-username").getValue();
        String password = secretClient.getSecret("db-password").getValue();

        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public BlobServiceClient blobServiceClient() {
        return new BlobServiceClientBuilder()
                .endpoint(String.format("https://%s.blob.core.windows.net", storageAccountName))
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }
}
