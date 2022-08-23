package committee.nova.petphrase.client;

import committee.nova.petphrase.config.Configuration;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class PetphraseClient implements ClientModInitializer {
    public static Configuration cfg;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(Configuration.class, GsonConfigSerializer::new);
        cfg = AutoConfig.getConfigHolder(Configuration.class).getConfig();
    }
}
