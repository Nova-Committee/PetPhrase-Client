package committee.nova.petphrase.proxies

import committee.nova.petphrase.client.config.ClientConfig
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

class ClientProxy extends CommonProxy {
  override def preInit(event: FMLPreInitializationEvent): Unit = ClientConfig.init(event)
}