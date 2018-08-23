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

	@Override
	public void prepare(Map map, TopologyContext context, OutputCollector collector) {
		this.map = map;
		this.context = context;
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		int i = input.getIntegerByField("n");
		sum = sum + i;
		System.out.println("bolt被调用之后的值为:" + sum);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
