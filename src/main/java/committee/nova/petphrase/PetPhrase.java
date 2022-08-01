package committee.nova.petphrase;

import committee.nova.petphrase.util.StringUtil;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(PetPhrase.MODID)
public class PetPhrase {
    public static final String MODID = "petphraseclient";
    public static final ForgeConfigSpec CLIENT_CONFIG;
    public static final ForgeConfigSpec.ConfigValue<String> petPhrase;

    static {
        final var builder = new ForgeConfigSpec.Builder();
        builder.comment("PetPhrase Configuration");
        petPhrase = builder.comment("The pet phrase apply to your messages")
                .define("petPhrase", "nya");
        CLIENT_CONFIG = builder.build();
    }

    public PetPhrase() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientChat(final ClientChatEvent event) {
        final var petPhrase = PetPhrase.petPhrase.get();
        if (petPhrase.isEmpty()) return;
        final var msg = event.getMessage();
        event.setMessage(StringUtil.fillPetPhraseIn(msg, petPhrase));
    }
}
