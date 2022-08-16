package committee.nova.petphrase;

import com.mumfrey.liteloader.ChatFilter;
import com.mumfrey.liteloader.core.LiteLoaderEventBroker;
import committee.nova.petphrase.config.Config;
import committee.nova.petphrase.util.StringUtil;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

import java.io.File;

public class LiteModPetPhrase implements ChatFilter {
    private static Config config;
    private static String petPhrase;

    public LiteModPetPhrase() {
    }

    @Override
    public String getName() {
        return "PetPhrase";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public void init(File configPath) {
        config = Config.of("petphrase-client-config", configPath.toPath()).provider(path -> "#PetPhrase Client Configs\npetPhrase=nya").request();
        petPhrase = config.getOrDefault("petPhrase", "nya");
    }

    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {

    }

    @Override
    public boolean onChat(ITextComponent chat, String message, LiteLoaderEventBroker.ReturnValue<ITextComponent> newMessage) {
        if (petPhrase.isEmpty()) return false;
        newMessage.set(new TextComponentString(StringUtil.fillPetPhraseIn(message, petPhrase)));
        return true;
    }
}