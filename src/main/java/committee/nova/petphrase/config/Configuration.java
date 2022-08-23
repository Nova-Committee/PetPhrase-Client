package committee.nova.petphrase.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "petPhrase")
public class Configuration implements ConfigData {
    @Comment("The pet phrase to be applied")
    public String petPhrase = "nya";
}
