package com.luokeke.storm.ws;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;

public class WSBlotCount implements IRichBolt {
	
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		// TODO Auto-generated method stub

	}

	public void execute(Tuple input) {
		String str = input.getStringByField("str");
		System.out.println("第二个Bolt工程，拿到了数据:" + str);
		Integer count = this.map.get(str);
		if (null == count || count == 0) {
			this.map.put(str, 1);
		} else {
			this.map.put(str, count + 1);
		}
		this.printMap();
	}
	
	private void printMap() {
		String string = "目前Map中的数据为：";
		for (String key : map.keySet()) {
			string  = string + "\t" + key + "=" + map.get(key);
		}
		System.out.println(string);
	}

	public void cleanup() {
		// TODO Auto-generated method stub

	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub

	}

	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
