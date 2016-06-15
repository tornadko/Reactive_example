package example.reactive.alex.reactiveexample.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import example.reactive.alex.reactiveexample.App;
import example.reactive.alex.reactiveexample.model.ActionType;
import trikita.anvil.RenderableView;
import trikita.jedux.Action;

import static trikita.anvil.BaseDSL.text;
import static trikita.anvil.DSL.MATCH;
import static trikita.anvil.DSL.button;
import static trikita.anvil.DSL.dip;
import static trikita.anvil.DSL.linearLayout;
import static trikita.anvil.DSL.margin;
import static trikita.anvil.DSL.o;
import static trikita.anvil.DSL.onClick;
import static trikita.anvil.DSL.orientation;
import static trikita.anvil.DSL.padding;
import static trikita.anvil.DSL.size;
import static trikita.anvil.DSL.textView;

public class MainActivity extends AppCompatActivity {

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

                        o(textView(),
                                margin(0, 30, 0, 40),
                                text("Hello. Total count:" + String.valueOf(App.getState().count()))),
                        o(button(),
                                text("+"),
                                margin(0, 0, 0, 20),
                                onClick(incrementListener)),
                        o(button(),
                                text("-"),
                                margin(0, 0, 0, 20),
                                onClick(decrementListener)),
                        o(button(),
                                text("Open new screen"),
                                onClick(openNewListener)));
            }
        });
    }

    private final View.OnClickListener incrementListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            App.dispatch(new Action<>(ActionType.INCREMENT));
        }
    };

    private final View.OnClickListener decrementListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            App.dispatch(new Action<>(ActionType.DECREMENT));
        }
    };

    private final View.OnClickListener openNewListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }
    };
}
