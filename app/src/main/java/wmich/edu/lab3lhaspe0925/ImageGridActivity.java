package wmich.edu.lab3lhaspe0925;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ImageGridActivity extends Activity {
    private Integer[] arrIntSports = {R.drawable.andredrummond, R.drawable.barrysanders, R.drawable.cabrera, R.drawable.calvinjohnson, R.drawable.redwings, R.drawable.webber_02};
    private String[] arrStrCaptions={"Andre Drummond","Barry Sanders","Miguele Cabrera","Calvin Johnson","Pavyl Datsuyk","Chris Webber"};
    private ImageView imgSports;
   private Integer viewWidth=260;
    private Integer viewHeight=260;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        Button btnBackToMain=(Button)findViewById(R.id.btnBackToMain);
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImageGridActivity.this,MainActivity.class));
                imgSports.setImageDrawable(null);
                imgSports.setVisibility(View.GONE);
            }
        });


        final GridView gvSportsImages = (GridView) findViewById(R.id.gvLayout);
        final ImageView imgSports = (ImageView) findViewById(R.id.imgImageHolder);

        gvSportsImages.setAdapter(new ImageAdapter(this));
        gvSportsImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String strToastByPosition;


                imgSports.setImageResource(arrIntSports[position]);
                if (position==0){
                    strToastByPosition=arrStrCaptions[0];
                }else if (position==1){
                    strToastByPosition=arrStrCaptions[1];
                }
                else if (position==2){
                    strToastByPosition=arrStrCaptions[2];

                }
                else if (position==3){
                    strToastByPosition=arrStrCaptions[3];

                }
                else if (position==4){
                    strToastByPosition=arrStrCaptions[4];

                }
                else{
                    strToastByPosition=arrStrCaptions[5];
                }
                Toast.makeText(getBaseContext(), "" + strToastByPosition, Toast.LENGTH_SHORT).show();


            }
        });
    }


    public class ImageAdapter extends BaseAdapter {
        private Context imageAdapterContext;
        public ImageAdapter(Context c){
            imageAdapterContext=c;

    }


        @Override
        public int getCount() {

            return arrIntSports.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            imgSports = new ImageView(imageAdapterContext);
            imgSports.setImageResource(arrIntSports[position]);
            imgSports.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            LinearLayout.LayoutParams imgDisplayed = new LinearLayout.LayoutParams(viewWidth, viewHeight);
            imgSports.setLayoutParams(imgDisplayed);
            return imgSports;
        }
    }

    }

