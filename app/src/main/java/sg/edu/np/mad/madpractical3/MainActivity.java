package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent number = getIntent();
        int randomInt = number.getIntExtra("number",0);
        User user = new User("John Doe","MAD Developer",1,false);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        Button msg = findViewById(R.id.button2);

        tvName.setText(user.name +" "+ randomInt);
        tvDescription.setText(user.description);
        if(user.followed == false){
            btnFollow.setText("Follow");
        }else{
            btnFollow.setText("Unfollow");
        }

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnFollow.getText() == "Follow"){
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT).show();
                }
                else{
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this,"Not Followed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(intent);

            }
        });
    }
}