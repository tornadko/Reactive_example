package example.reactive.alex.reactiveexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import trikita.anvil.RenderableView;
import trikita.jedux.Action;

import static trikita.anvil.BaseDSL.MATCH;
import static trikita.anvil.BaseDSL.dip;
import static trikita.anvil.BaseDSL.margin;
import static trikita.anvil.BaseDSL.o;
import static trikita.anvil.BaseDSL.padding;
import static trikita.anvil.BaseDSL.size;
import static trikita.anvil.BaseDSL.text;
import static trikita.anvil.DSL.button;
import static trikita.anvil.DSL.linearLayout;
import static trikita.anvil.DSL.onClick;
import static trikita.anvil.DSL.orientation;
import static trikita.anvil.DSL.textView;

/**
 * Created by Alex on 01.06.2016.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(new RenderableView(this) {
            @Override
            public void view() {
                o(linearLayout(),
                        size(MATCH, MATCH),
                        padding(dip(20)),
                        orientation(LinearLayout.VERTICAL),


                        o(button(),
                                text("+"),
                                margin(0, 0, 0, 20),
                                onClick(incrementListener)));
            }
        });
    }

    private final View.OnClickListener incrementListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            App.dispatch(new Action<>(ActionType.INCREMENT));
        }
    };
}
