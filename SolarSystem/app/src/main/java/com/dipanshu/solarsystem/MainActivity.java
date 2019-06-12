package com.dipanshu.solarsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<data> datalist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datalist.add(new data("Earth","hello everyone ! my name is earth","https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F9%2F97%2FThe_Earth_seen_from_Apollo_17.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FEarth&docid=88gjCNbYu3-8ZM&tbnid=YgY4l5SdNTT6OM%3A&vet=10ahUKEwjjo4zso9XdAhUGX30KHQjVDToQMwjJAygAMAA..i&w=3000&h=3002&bih=721&biw=1707&q=earth&ved=0ahUKEwjjo4zso9XdAhUGX30KHQjVDToQMwjJAygAMAA&iact=mrc&uact=8"));
        datalist.add(new data("Sun","hello everyone ! my name is sun","https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.pexels.com%2Fphotos%2F87611%2Fsun-fireball-solar-flare-sunlight-87611.jpeg%3Fauto%3Dcompress%26cs%3Dtinysrgb%26h%3D350&imgrefurl=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Fsun%2F&docid=_fD5XoaNdUP2YM&tbnid=xpaUnwqlhvnfVM%3A&vet=10ahUKEwiUv9iswr7dAhWJRo8KHRi0DvQQMwiBAigDMAM..i&w=367&h=350&bih=651&biw=1366&q=photos%20of%20sun&ved=0ahUKEwiUv9iswr7dAhWJRo8KHRi0DvQQMwiBAigDMAM&iact=mrc&uact=8"));
        datalist.add(new data("Mars","hello everyone ! my name is mars","https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F0%2F02%2FOSIRIS_Mars_true_color.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FMars&docid=2MaOREgBqn61_M&tbnid=P4MIAQTs-y3JQM%3A&vet=10ahUKEwjRmPm7wr7dAhUMqY8KHYWUApgQMwjOASgHMAc..i&w=2205&h=2205&bih=651&biw=1366&q=photos%20of%20mars&ved=0ahUKEwjRmPm7wr7dAhUMqY8KHYWUApgQMwjOASgHMAc&iact=mrc&uact=8"));
        datalist.add(new data("Venus","hello everyone ! my name is venus","https://www.google.com/imgres?imgurl=http%3A%2F%2Fplanetary.s3.amazonaws.com%2Fassets%2Fimages%2F2-venus%2F20180113_uvi_20160517_201715_365_l2b_v10_PseudoRGB_f840.jpg&imgrefurl=http%3A%2F%2Fwww.planetary.org%2Fblogs%2Fguest-blogs%2F2018%2F0116-a-new-look-at-venus-with-akatsuki.html&docid=ZATq9weNedvxpM&tbnid=Xu4gc-yR7218YM%3A&vet=10ahUKEwiopYPIwr7dAhXKNo8KHShpDhcQMwj8ASgDMAM..i&w=840&h=840&bih=651&biw=1366&q=photos%20of%20venus&ved=0ahUKEwiopYPIwr7dAhXKNo8KHShpDhcQMwj8ASgDMAM&iact=mrc&uact=8"));
        datalist.add(new data("Saturn","hello everyone ! my name is saturn","https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fc%2Fc7%2FSaturn_during_Equinox.jpg%2F1200px-Saturn_during_Equinox.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FSaturn&docid=LsVbrq0jlRRMXM&tbnid=zyppPy5JYn3rIM%3A&vet=10ahUKEwi2tKfYwr7dAhVMMY8KHb8TBgsQMwiQAigBMAE..i&w=1199&h=581&bih=651&biw=1366&q=photos%20of%20saturn&ved=0ahUKEwi2tKfYwr7dAhVMMY8KHb8TBgsQMwiQAigBMAE&iact=mrc&uact=8"));
        datalist.add(new data("Neptune","hello everyone ! my name is neptune","https://www.google.com/imgres?imgurl=https%3A%2F%2Fvoyager.jpl.nasa.gov%2Fassets%2Fimages%2Fgalleries%2Fimages-voyager-took%2Fneptune%2Fneptunex.gif&imgrefurl=https%3A%2F%2Fvoyager.jpl.nasa.gov%2Fgalleries%2Fimages-voyager-took%2Fneptune%2F&docid=XiUiUU9j9JfGgM&tbnid=SeTJig1NnN4Q_M%3A&vet=10ahUKEwjwyuviwr7dAhVEPo8KHbhLBFUQMwiLAigBMAE..i&w=650&h=650&bih=651&biw=1366&q=photos%20of%20neptune&ved=0ahUKEwjwyuviwr7dAhVEPo8KHbhLBFUQMwiLAigBMAE&iact=mrc&uact=8"));
        datalist.add(new data("Mercury","hello everyone ! my name is Mercury","https://www.google.com/imgres?imgurl=http%3A%2F%2Fwww.astronomy.com%2F-%2Fmedia%2FImages%2FNews%2520and%2520Observing%2FNews%2F2018%2F03%2Fspectra_mercury.jpg%3Fmw%3D600&imgrefurl=http%3A%2F%2Fwww.astronomy.com%2Fnews%2F2018%2F03%2Fmercury-the-swift-planet&docid=Z6_BYnXIHxTNEM&tbnid=TMlN2eeCr8BIUM%3A&vet=10ahUKEwjE4Mjswr7dAhXFK48KHe8dAo4QMwiwASgBMAE..i&w=600&h=600&bih=651&biw=1366&q=photos%20of%20mercury&ved=0ahUKEwjE4Mjswr7dAhXFK48KHe8dAo4QMwiwASgBMAE&iact=mrc&uact=8"));
        datalist.add(new data("Uranus","hello everyone ! my name is Uranus","https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F3%2F3d%2FUranus2.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FUranus&docid=AqgUFEakr4_-lM&tbnid=rzdgJ5KbcGMs6M%3A&vet=10ahUKEwj32f31wr7dAhWHQ48KHfFRAEAQMwi3ASgBMAE..i&w=1720&h=1720&bih=651&biw=1366&q=photos%20of%20uranus&ved=0ahUKEwj32f31wr7dAhWHQ48KHfFRAEAQMwi3ASgBMAE&iact=mrc&uact=8"));

        RecyclerView recyclerView = findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        Data_adapter adapter = new Data_adapter(datalist);
        recyclerView.setAdapter(adapter);
    }
}
