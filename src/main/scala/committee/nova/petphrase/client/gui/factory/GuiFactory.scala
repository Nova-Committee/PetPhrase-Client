package committee.nova.petphrase.client.gui.factory

import committee.nova.petphrase.client.gui.screen.GuiScreenConfig
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiScreen
import net.minecraftforge.fml.client.IModGuiFactory

import java.util
import java.util.Collections

class GuiFactory extends IModGuiFactory {
  override def initialize(minecraftInstance: Minecraft): Unit = {}

  override def hasConfigGui: Boolean = true

  override def createConfigGui(parentScreen: GuiScreen): GuiScreen = new GuiScreenConfig(parentScreen)

  override def runtimeGuiCategories(): util.Set[IModGuiFactory.RuntimeOptionCategoryElement] = Collections.emptySet()
}
