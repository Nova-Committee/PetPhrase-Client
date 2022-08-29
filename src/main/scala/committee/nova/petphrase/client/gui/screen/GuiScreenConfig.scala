package committee.nova.petphrase.client.gui.screen

import committee.nova.petphrase.PetPhrase
import committee.nova.petphrase.client.config.ClientConfig
import cpw.mods.fml.client.config.GuiConfig
import net.minecraft.client.gui.GuiScreen
import net.minecraftforge.common.config.{ConfigElement, Configuration}

class GuiScreenConfig(parent: GuiScreen) extends GuiConfig(parent,
    new ConfigElement(ClientConfig.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements,
    PetPhrase.MODID,
    PetPhrase.MODID,
    false,
    false,
    "PetPhrase-Client Config"
)
