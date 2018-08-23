package com.luokeke.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class WsBolt extends BaseRichBolt {

	Map map;
	TopologyContext context;
	OutputCollector collector;
	int sum = 0;

	public void prepare(Map map, TopologyContext context, OutputCollector collector) {
		this.map = map;
		this.context = context;
		this.collector = collector;
	}

	public void execute(Tuple input) {
		int i = input.getIntegerByField("n");
		sum = sum + i;
		System.out.println(String.format("bolt接收到參數為：%s，计算结果为:%s", i, sum));
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
