package cat.udl.tidic.amd.dotsboxes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class RepeatDialogFragment extends DialogFragment {
    static String winner;

    public static RepeatDialogFragment newInstance(String win){
        RepeatDialogFragment frag = new RepeatDialogFragment();
        winner = win;
        return frag;
    }
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage("The winner is: "+ winner)
                .setPositiveButton("Repetir", (dialog, which) -> {
                    GameActivity.ga.restart();
                } ).setNegativeButton("Acabar",(dialog,which)->{
                    GameActivity.intentChangeStart();
                })
                .create();
    }

}
