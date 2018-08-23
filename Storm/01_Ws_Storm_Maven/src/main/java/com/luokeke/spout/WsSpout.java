package com.luokeke.spout;

import java.util.List;
import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class WsSpout extends BaseRichSpout {
	Map map;
	TopologyContext context;
	SpoutOutputCollector collector;
	int i = 0;

	public void open(Map map, TopologyContext context, SpoutOutputCollector collector) {
		this.map = map;
		this.context = context;
		this.collector = collector;
	}

	public void nextTuple() {
		i++;
		List tuple = new Values(i);
		System.out.println("调用bolt的参数为：" + i);
		this.collector.emit(tuple);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("n"));
	}

}
