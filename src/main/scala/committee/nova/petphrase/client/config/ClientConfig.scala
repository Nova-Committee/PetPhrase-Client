package committee.nova.petphrase.client.config

import net.minecraftforge.common.config.Configuration
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
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
    petPhrase = config.getString("petPhrase", Configuration.CATEGORY_CLIENT, "nya", "The pet phrase which should be added into your messages", "config.petphraseclient.petPhrase.info")
    config.save()
  }
}
