package wmich.edu.lab3lhaspe0925;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    private final String strDefaultToastMessage="Make a choice";
    private final String strNba="http://www.nba.com/pistons/?hp=1&ls=iref:pistons:gameexp:returnbutton";
    private final String strNfl="http://www.detroitlions.com/";
    private final String strNhl="http://redwings.nhl.com/";
   private final String strMlb="http://detroit.tigers.mlb.com/index.jsp?c_id=det";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] arrSports ={"    Detroit Pistons", "    Detroit Lions", "    Detroit Redwings", "    Detroit Tigers", "    Image Gallery", "    Great Calls","    Full Screen Image"};
        setListAdapter(new ArrayAdapter<>(this, R.layout.activity_main, R.id.sports, arrSports));
            }

    protected void onListItemClick(ListView L, View V, int position, long id){

        //Switch with case statements based on position in list.

        switch(position){
            //case Detroit Pistons
            case 0:{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(strNba)));

                break;
            }
            //case Detroit Lions
            case 1:{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(strNfl)));

                break;
            }
            //case Detroit Redwings
            case 2:{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(strNhl)));

                break;

            }
            //case Detroit Tigers
            case 3:{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(strMlb)));

                break;
            }
            //case Image Gallery
            case 4:{
                startActivity(new Intent(MainActivity.this,ImageGridActivity.class));
                break;
            }
            //case Great Calls
            case 5:{
                startActivity(new Intent(MainActivity.this,SportsSoundsActivity.class));
                break;
            }
            //case Full Screen Image
            case 6:{
                startActivity(new Intent(MainActivity.this,ImgFullScreen.class));
                break;
            }
            //case default
            default:{
                Toast.makeText(MainActivity.this,strDefaultToastMessage,Toast.LENGTH_LONG).show();
                break;

            }
        }//end Switch
    }//end onListItemClick method
}//end OnCreate method

