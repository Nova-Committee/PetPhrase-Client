package committee.nova.petphrase.client;

import committee.nova.petphrase.config.Config;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class PetphraseClient implements ClientModInitializer {
    public static Config config;
    public static String petPhrase;

    @Override
    public void onInitializeClient() {
        config = Config.of("petphrase-client-config").provider((path) -> "#PetPhrase Client Configs\npetPhrase=nya").request();
        petPhrase = config.getOrDefault("petPhrase", "nya");
    }
}
