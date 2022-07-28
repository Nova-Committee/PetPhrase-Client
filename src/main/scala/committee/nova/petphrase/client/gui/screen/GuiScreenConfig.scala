package committee.nova.petphrase.client.gui.screen

import committee.nova.petphrase.PetPhraseClient
import committee.nova.petphrase.client.config.ClientConfig
import net.minecraft.client.gui.GuiScreen
import net.minecraftforge.common.config.{ConfigElement, Configuration}
import net.minecraftforge.fml.client.config.GuiConfig

class GuiScreenConfig(parent: GuiScreen) extends GuiConfig(parent,
    new ConfigElement(ClientConfig.config.getCategory(Configuration.CATEGORY_CLIENT)).getChildElements,
    PetPhraseClient.MODID,
    PetPhraseClient.MODID,
    false,
    false,
    "PetPhrase-Client Config"
)
