package ca.csf.pobj.tp2.Unit.Unit;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import ca.csf.pobj.tp2.R;
import ca.csf.pobj.tp2.Unit.Util.StringUtil;

public class MainActivity extends AppCompatActivity {

    private View rootView;
    private EditText inputEditText;
    private TextView outputTextView;

    private UnitConverter unitConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.rootView);
        inputEditText = findViewById(R.id.inputEditText);
        outputTextView = findViewById(R.id.outputTextView);

        unitConverter = new UnitConverter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("save_output", outputTextView.getText().toString());
        outState.putString("save_input", outputTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        outputTextView.setText(savedInstanceState.getString("save_output"));
        inputEditText.setText(savedInstanceState.getString("save_input"));
    }

    public void onConvertToRomanButtonClicked(View view) {
        if (isInputBlank()) {
            showEmptyInputMessage();
        }
        else if (isInputWrong()){
            showWrongInputMessage();
        }
        else{
            setOutput(getInput());
        }
    }

    private void showEmptyInputMessage() {
        Snackbar.make(rootView,R.string.error_empty_input,Snackbar.LENGTH_SHORT).show();
    }

    private void showWrongInputMessage() {
        Snackbar.make(rootView,R.string.error_wrong_input,Snackbar.LENGTH_SHORT).show();
    }

    private boolean isInputBlank (){
        return StringUtil.isBlank(inputEditText.getText().toString());
    }

    private boolean isInputWrong (){
        return (Integer.parseInt(inputEditText.getText().toString()) > 4999 ||
                Integer.parseInt(inputEditText.getText().toString()) < 1);
    }

    private Integer getInput(){
        return Integer.parseInt(inputEditText.getText().toString());
    }

    private void setOutput (Integer value){
        outputTextView.setText(unitConverter.convertIntToRomanString(value));
    }

}
