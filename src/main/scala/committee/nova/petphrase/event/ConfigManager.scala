package committee.nova.petphrase.event

import committee.nova.petphrase.PetPhrase
import committee.nova.petphrase.client.config.ClientConfig
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent
import cpw.mods.fml.common.FMLCommonHandler
import cpw.mods.fml.common.eventhandler.SubscribeEvent

object ConfigManager {
  def init(): Unit = FMLCommonHandler.instance().bus().register(new ConfigManager)
}

class ConfigManager {
  @SubscribeEvent
  def onConfigChange(event: OnConfigChangedEvent): Unit = {
    if (event.modID.equals(PetPhrase.MODID)) {
      ClientConfig.config.save()
      ClientConfig.sync()
    }
  }
}