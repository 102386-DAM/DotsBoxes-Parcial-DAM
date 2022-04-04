package cat.udl.tidic.amd.dotsboxes.viewmodels;

import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.tidic.amd.dotsboxes.models.Game;

// TODO
public class GameViewModel extends ViewModel {
    public TextView torn;
    public String torp;




    public void setTW(TextView tw) {
        this.torn = tw;
    }
}

