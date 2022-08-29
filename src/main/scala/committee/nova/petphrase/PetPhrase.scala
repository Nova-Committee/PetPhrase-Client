package committee.nova.petphrase

import committee.nova.petphrase.proxies.CommonProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = PetPhrase.MODID, useMetadata = true, acceptedMinecraftVersions = "[1.7,)", modLanguage = "scala", guiFactory = "committee.nova.petphrase.client.gui.factory.GuiFactory")
object PetPhrase {
  final val MODID = "petphrase"
  final val packagePrefix = "committee.nova.petphrase.proxies."

  @SidedProxy(serverSide = packagePrefix + "CommonProxy", clientSide = packagePrefix + "ClientProxy")
  var proxy: CommonProxy = _

  @EventHandler def preInit(e: FMLPreInitializationEvent): Unit = proxy.preInit(e)

  @EventHandler def init(e: FMLInitializationEvent): Unit = proxy.init(e)
}
