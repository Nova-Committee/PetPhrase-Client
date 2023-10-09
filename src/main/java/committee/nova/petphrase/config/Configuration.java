package committee.nova.petphrase.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import java.util.List;

@Config(name = "petphrase")
public class Configuration implements ConfigData {
    @Comment("The pet phrase to be applied")
    public String petPhrase = "nya";
    @Comment("If the message to be sent starts with any word in the list, petPhrase won't be applied on the message.")
    public List<String> filteredPrefix = List.of("/", "!", "xaero-waypoint");
}
