package committee.nova.petphrase.client;

import committee.nova.petphrase.config.SimpleConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class PetphraseClient implements ClientModInitializer {
    public static SimpleConfig config;
    private static String petPhrase;

    @Override
    public void onInitializeClient() {
        config = SimpleConfig.of("petphrase-client-config").provider(path -> "#PetPhrase Client Configs\npetPhrase=nya").request();
        petPhrase = config.getOrDefault("petPhrase", "nya");
    }

    public static String getPetPhrase() {
        return petPhrase;
    }
}
