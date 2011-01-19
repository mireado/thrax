package edu.jhu.thrax.hadoop.features;

import edu.jhu.thrax.hadoop.datatypes.RuleWritable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.util.Map;

public class TargetWordCounterFeature extends SimpleFeature
{
    private static final Text LABEL = new Text("TargetWords");

    public TargetWordCounterFeature()
    {
        super("target-word-count");
    }

    public void score(RuleWritable r)
    {
        int words = 0;
        for (String tok : r.target.toString().split("\\s+")) {
            if (!tok.startsWith("[")) {
                words++;
            }
        }
        r.features.put(LABEL, new IntWritable(words));
        return;
    }

    public void score(RuleWritable r, Map<Text,Writable> map)
    {
        int words = 0;
        for (String tok : r.target.toString().split("\\s+")) {
            if (!tok.startsWith("[")) {
                words++;
            }
        }
        map.put(LABEL, new IntWritable(words));
        return;
    }
}
