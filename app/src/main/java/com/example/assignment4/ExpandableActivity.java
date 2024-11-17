package com.example.assignment4;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> groupData;
    HashMap<String, List<String>> childData;
    int lastExpandedGroup = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expandable);
        expandableListView = findViewById(R.id.expandableListView);
        data();
        ExpandableListAdapter adapter =  new ExpandableListAdapter(this, groupData, childData);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                String groupText = groupData.get(i);
                Toast.makeText(getApplicationContext(), groupText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                String groupText = groupData.get(i);
                Toast.makeText(getApplicationContext(), groupText + " is Collapsed", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long id) {
                String childText = childData.get(groupData.get(i)).get(i1);
                Toast.makeText(getApplicationContext(), childText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedGroup != -1 && lastExpandedGroup != i){
                    expandableListView.collapseGroup(lastExpandedGroup);
                }
                lastExpandedGroup = i;
            }
        });
    }

    private void data() {
        String[] headerString = getResources().getStringArray(R.array.Social_Media_array);
        String[] childString = getResources().getStringArray(R.array.Social_Media_array_subtitle);
        groupData = new ArrayList<>();
        childData = new HashMap<>();

        for (int i = 0; i<headerString.length; i++) {
            groupData.add(headerString[i]);
            List<String> child = new ArrayList<>();
            child.add(childString[i]);
            childData.put(groupData.get(i), child);
        }
    }
}