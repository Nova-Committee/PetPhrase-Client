package committee.nova.petphrase.mixin;

import committee.nova.petphrase.client.config.ClientConfig$;
import committee.nova.petphrase.util.StringUtil$;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiChat.class)
public abstract class MixinGuiChat extends GuiScreen {
    @Inject(method = "func_146403_a", at = @At("HEAD"), cancellable = true)
    public void onSendMsg(String msg, CallbackInfo ci) {
        final String newMsg = StringUtil$.MODULE$.fillPetPhraseIn(msg, ClientConfig$.MODULE$.petPhrase());
        this.mc.ingameGUI.getChatGUI().addToSentMessages(newMsg);
        if (net.minecraftforge.client.ClientCommandHandler.instance.executeCommand(mc.thePlayer, newMsg) != 0) {
            ci.cancel();
            return;
        }
        this.mc.thePlayer.sendChatMessage(newMsg);
        ci.cancel();
    }
}
