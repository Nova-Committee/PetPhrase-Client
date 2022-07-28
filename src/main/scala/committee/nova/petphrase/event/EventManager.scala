package committee.nova.petphrase.event

import committee.nova.petphrase.client.config.ClientConfig
import committee.nova.petphrase.util.StringUtil
import net.minecraftforge.client.event.ClientChatEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side

@EventBusSubscriber(Array(Side.CLIENT))
object EventManager {
  @SubscribeEvent
  def onChat(event: ClientChatEvent): Unit = {
    val phrase = ClientConfig.petPhrase
    if (phrase.isEmpty) return
    event.setMessage(StringUtil.fillPetPhraseIn(event.getMessage, phrase))
  }
}
