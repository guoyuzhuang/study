package com.luokeke.storm.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class WSSpout implements IRichSpout {

	Map conf;
	TopologyContext context;
	SpoutOutputCollector collector;

	BufferedReader br = null;
	int index = 1;

	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		try {
			FileInputStream fs = new FileInputStream("track.log");
			InputStreamReader isr = new InputStreamReader(fs, "UTF-8");
			br = new BufferedReader(isr);

			this.collector = collector;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//每次调用，都应该获取一个新的行数
	public void nextTuple() {
		try {
			String line = br.readLine();
			if (line != null) {
				collector.emit(new Values(line), index);
				System.out.println("WSSpout类发送数据为：" + line);
				index++;
			} else {
				System.out.println("数据读取完毕");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public void activate() {
		// TODO Auto-generated method stub

	}

	public void deactivate() {
		// TODO Auto-generated method stub

	}

	public void ack(Object msgId) {
		// TODO Auto-generated method stub

	}

	public void fail(Object msgId) {
		// TODO Auto-generated method stub

	}

	//声明传参引用名称
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("log"));
	}

	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
