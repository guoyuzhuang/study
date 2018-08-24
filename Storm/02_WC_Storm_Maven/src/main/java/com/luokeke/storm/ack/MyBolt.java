package com.luokeke.storm.ack;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class MyBolt implements IRichBolt {

	private static final long serialVersionUID = 1L;

	OutputCollector collector = null;
	int num = 0;
	String valueString = null;

	public void cleanup() {

	}

	public void execute(Tuple input) {
		try {
			valueString = input.getStringByField("log");

			if (valueString != null) {
				num++;
				/*System.err.println(input.getSourceStreamId() + " " + Thread.currentThread().getName() + "--id="
						+ Thread.currentThread().getId() + "   lines  :" + num + "   session_id:"
						+ valueString.split("\t")[1]);*/
				String str = getStr(valueString);
				System.out.println(String.format("收到的字符串为：%s", str));
			}
//			collector.ack(input);
			// Thread.sleep(2000);
		} catch (Exception e) {
			collector.fail(input);
			e.printStackTrace();
		}

	}

	private String getStr(String valueString2) {
		String[] arr = valueString2.split("\t");
		String str = "";
		for (String i : arr) {
			str = str + "---" + i;
		}
		return str;
	}

	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields(""));
	}

	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
