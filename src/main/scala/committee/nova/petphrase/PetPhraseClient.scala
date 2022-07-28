package committee.nova.petphrase

import committee.nova.petphrase.PetPhraseClient.MODID
import committee.nova.petphrase.proxies.CommonProxy
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.{Mod, SidedProxy}

@Mod(modid = MODID, useMetadata = true, clientSideOnly = true, modLanguage = "scala", guiFactory = "committee.nova.petphrase.client.gui.factory.GuiFactory")
object PetPhraseClient {
  final val MODID = "petphraseclient"
  final val packagePrefix = "committee.nova.petphrase.proxies."

  @SidedProxy(serverSide = packagePrefix + "CommonProxy", clientSide = packagePrefix + "ClientProxy")
  var proxy: CommonProxy = _

  @EventHandler def preInit(e: FMLPreInitializationEvent): Unit = proxy.preInit(e)
}
