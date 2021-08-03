/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fuzzy;

import fuzzy.dtos.Person;
import fuzzy.dtos.WalkVelocity;
import fuzzy.operators.groupby.FuzzyGroupBy;
import fuzzy.operators.join.FuzzyJoin;
import fuzzy.operators.join.IFuzzyJoin;
import fuzzy.operators.join.joinDefinitions.IFuzzyJoinDefinition;
import fuzzy.operators.join.joinDefinitions.WalkingPersonJoinDefinition;
import fuzzy.operators.select.projections.PersonProjection;
import fuzzy.operators.join.projections.WalkingPersonProjection;
import fuzzy.operators.select.FuzzySelect;
import fuzzy.operators.select.IFuzzySelect;
import fuzzy.operators.where.FuzzyWhere;
import fuzzy.operators.where.IFuzzyFilter;
import fuzzy.operators.where.IFuzzyWhere;
import fuzzy.operators.where.YoungPeopleFilter;
import fuzzy.variables.LinguisticAge;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;
import java.util.List;


/**
 * Skeleton for a Flink Streaming Job.
 *
 * <p>For a tutorial how to write a Flink streaming application, check the
 * tutorials and examples on the <a href="https://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
public class StreamingJob {

	public static void main(String[] args) throws Exception {
		// set up the streaming execution environment
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		//DATA DEFINITION//
		List<Person> input = Arrays.asList(
				new Person(0, "arek", 14),
				new Person(1, "marek", 26),
				new Person(2, "darek", 50)
		);
		DataStream<Person> inputDataStream = env.fromCollection(input);

		List<WalkVelocity> inputWalkVelocity = Arrays.asList(
				new WalkVelocity(0, "fast", 14),
				new WalkVelocity(1, "slow", 50)
		);
		DataStream<WalkVelocity> inputWalkVelocityDataStream = env.fromCollection(inputWalkVelocity);


	    //WHERE//
		// filter definition
		IFuzzyFilter<Person> youngPeopleFilter = new YoungPeopleFilter();
		youngPeopleFilter.setLowerBound(13);
		youngPeopleFilter.setUpperBound(20);
		youngPeopleFilter.setMembershipCoefficient(0.2);
		IFuzzyWhere<Person> fuzzyWhere = new FuzzyWhere();
		DataStream<Person> outWhereDataStream = fuzzyWhere.transform(inputDataStream, youngPeopleFilter);

		//SELECT//
		IFuzzySelect<PersonProjection, Person> fuzzySelect = new FuzzySelect();
		DataStream<PersonProjection> outSelectDataStream = fuzzySelect.transform(inputDataStream, new PersonProjection());

		//JOIN//
		IFuzzyJoinDefinition<WalkingPersonProjection, Person, WalkVelocity> joinDefinition = new WalkingPersonJoinDefinition();
		IFuzzyJoin<Person, WalkVelocity> fuzzyJoin = new FuzzyJoin();
		DataStream<WalkingPersonProjection> outJoinDataStream = fuzzyJoin.transform(inputDataStream, inputWalkVelocityDataStream, person -> new LinguisticAge(person.age).returnStringValue(), walkVelocity -> new LinguisticAge(walkVelocity.age).returnStringValue(), joinDefinition.getFunction());


		//GROUP BY//
		FuzzyGroupBy<Person, String> fuzzyGroupBy = new FuzzyGroupBy();
		DataStream<Person> outGroupByDataStream = fuzzyGroupBy.transform(inputDataStream, person -> new LinguisticAge(person.age).returnStringValue());

		outWhereDataStream.print("Fuzzy Where");
		outSelectDataStream.print("Fuzzy Select");
		outJoinDataStream.print("Fuzzy Join");
		outGroupByDataStream.print("Fuzzy Group By");

		env.execute("Fuzzy transformations");
	}
}
