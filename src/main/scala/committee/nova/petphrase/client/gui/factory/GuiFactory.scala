package committee.nova.petphrase.client.gui.factory

import committee.nova.petphrase.client.gui.screen.GuiScreenConfig
import cpw.mods.fml.client.IModGuiFactory
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiScreen

import java.util
import java.util.Collections

class GuiFactory extends IModGuiFactory {
  override def initialize(minecraftInstance: Minecraft): Unit = {}

  override def runtimeGuiCategories(): util.Set[IModGuiFactory.RuntimeOptionCategoryElement] = Collections.emptySet()

  override def mainConfigGuiClass(): Class[_ <: GuiScreen] = classOf[GuiScreenConfig]

  override def getHandlerFor(element: IModGuiFactory.RuntimeOptionCategoryElement): IModGuiFactory.RuntimeOptionGuiHandler = null
}
