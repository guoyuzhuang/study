package com.luokeke.storm.ack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;

public class MySpout implements IRichSpout{
	
	private static final long serialVersionUID = 1L;
	
	private SpoutOutputCollector collector;
	private FileInputStream fis;
	private InputStreamReader isr;
	private BufferedReader br;

	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		try {
			this.collector = collector;
			this.fis = new FileInputStream("track.log");
			this.isr = new InputStreamReader(fis, "UTF-8");
			this.br = new BufferedReader(isr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activate() {
		
	}

	public void deactivate() {
		
	}

	public void nextTuple() {
		
	}

	public void ack(Object msgId) {
		System.err.println(" [" + Thread.currentThread().getName() + "] "+ " spout ack:"+msgId.toString());
	}

	public void fail(Object msgId) {
		System.err.println(" [" + Thread.currentThread().getName() + "] "+ " spout fail:"+msgId.toString());
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("log"));
	}

	public Map<String, Object> getComponentConfiguration() {
		return null;
	}


}
