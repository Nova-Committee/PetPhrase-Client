package committee.nova.petphrase.client.config

import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.common.config.Configuration
import org.apache.logging.log4j.Logger

object ClientConfig {
  var petPhrase: String = ""
  var config: Configuration = _
  private var logger: Logger = _

  def init(event: FMLPreInitializationEvent): Unit = {
    logger = event.getModLog
    config = new Configuration(event.getSuggestedConfigurationFile)
    sync()
  }

  def sync(): Unit = {
    config.load()
    petPhrase = config.getString("petPhrase", Configuration.CATEGORY_GENERAL, "nya", "The pet phrase which should be added into your messages", "config.petphraseclient.petPhrase.info")
    config.save()
  }
}
