package committee.nova.petphrase.proxies

import committee.nova.petphrase.client.config.ClientConfig
import committee.nova.petphrase.event.ConfigManager
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}

class ClientProxy extends CommonProxy {
  override def preInit(event: FMLPreInitializationEvent): Unit = ClientConfig.init(event)

  override def init(event: FMLInitializationEvent): Unit = ConfigManager.init()
}
