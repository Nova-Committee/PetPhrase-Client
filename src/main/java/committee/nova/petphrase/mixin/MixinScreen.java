package committee.nova.petphrase.mixin;

import committee.nova.petphrase.client.PetphraseClient;
import committee.nova.petphrase.util.StringUtil;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public abstract class MixinScreen {
    @Shadow
    public abstract void sendMessage(String message, boolean toHud);

    @Inject(method = "sendMessage(Ljava/lang/String;)V", at = @At("HEAD"), cancellable = true)
    public void onSendMessage(String message, CallbackInfo ci) {
        final String newMsg = StringUtil.fillPetPhraseIn(message, PetphraseClient.getPetPhrase());
        this.sendMessage(newMsg, true);
        ci.cancel();
    }
}
