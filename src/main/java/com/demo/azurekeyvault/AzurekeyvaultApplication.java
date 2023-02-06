package com.demo.azurekeyvault;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AzurekeyvaultApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AzurekeyvaultApplication.class, args);
	}

	@Override
	public void run(String...args) {
		System.out.println(">>>>>>>>>>> Ingreso a run <<<<<<<<<<<<<<<<<<<");
		ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
				.clientId("<YOUR_CLIENT_ID>")
				.clientSecret("<YOUR_CLIENT_SECRET>")
				.tenantId("")
				.build();
		SecretClient secretClient = new SecretClientBuilder()
				.vaultUrl("https://{YOUR_VAULT_NAME}.vault.azure.net")
				.credential(clientSecretCredential)
				.buildClient();
		System.out.println("<SECRET>: " + secretClient.getSecret("<SECRET>").getValue());
	}

}
