package com.luokeke.storm.ws;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

public class WSTest {

	public static void main(String[] args) {
		
		TopologyBuilder tb = new TopologyBuilder();
		tb.setSpout("WSSpout", new WSSpout());
		tb.setBolt("WSBolt", new WSBolt()).shuffleGrouping("WSSpout");
		tb.setBolt("WSBoltCount", new WSBlotCount()).shuffleGrouping("WSBolt");
		
		Config conf = new Config();
//		conf.setDebug(true);
		conf.setMessageTimeoutSecs(conf, 100);
		conf.setNumAckers(4);
		
		LocalCluster lc = new LocalCluster();
		lc.submitTopology("luokeke_WS", conf, tb.createTopology());
	}
}
