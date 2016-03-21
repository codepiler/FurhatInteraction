package iristk.app.interaction;

import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import static iristk.util.Converters.*;

public class InteractionFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private iristk.situated.SystemAgent system;
	private Integer number;

	private void initVariables() {
		system = agent.getSystemAgent();
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer value) {
		this.number = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("number")) return this.number;
		if (name.equals("agent")) return this.agent;
		return null;
	}


	public InteractionFlow(iristk.situated.SystemAgentFlow agent) {
		this.agent = agent;
		initVariables();
	}

	@Override
	protected State getInitialState() {return new Idle();}

	public static String[] getPublicStates() {
		return new String[] {};
	}

	private class Idle extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() {
			int eventResult;
			Event event = new Event("state.enter");
			EXECUTION: {
				int count = getCount(1490180672) + 1;
				incrCount(1490180672);
				if (system.hasUsers()) {
					iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 15, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					Greeting state1 = new Greeting();
					flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 17, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				} else {
					iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 15, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			}
		}

		@Override
		public int onFlowEvent(Event event) {
			int eventResult;
			int count;
			count = getCount(358699161) + 1;
			if (event.triggers("sense.user.enter")) {
				incrCount(358699161);
				eventResult = EVENT_CONSUMED;
				EXECUTION: {
					iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
					state3.setTarget(event.get("user"));
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 22, 36)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					Greeting state4 = new Greeting();
					flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 24, 28)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				if (eventResult != EVENT_IGNORED) return eventResult;
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Greeting extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() {
			int eventResult;
			Event event = new Event("state.enter");
			EXECUTION: {
				int count = getCount(110718392) + 1;
				incrCount(110718392);
				iristk.situated.SystemAgentFlow.say state5 = agent.new say();
				state5.setText("Hi there, let's play a game");
				if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 29, 12)))) {
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				Start state6 = new Start();
				flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 31, 25)));
				eventResult = EVENT_ABORTED;
				break EXECUTION;
			}
		}

		@Override
		public int onFlowEvent(Event event) {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() {
			int eventResult;
			Event event = new Event("state.enter");
			EXECUTION: {
				int count = getCount(1100439041) + 1;
				incrCount(1100439041);
				number = new java.util.Random().nextInt(10) + 1;
				system.putUsers("guesses", 0);
				iristk.situated.SystemAgentFlow.say state7 = agent.new say();
				state7.setText("I am thinking of a number between 1 and 10.");
				if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 36, 12)))) {
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				Guess state8 = new Guess();
				flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 40, 25)));
				eventResult = EVENT_ABORTED;
				break EXECUTION;
			}
		}

		@Override
		public int onFlowEvent(Event event) {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Guess extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() {
			int eventResult;
			Event event = new Event("state.enter");
			EXECUTION: {
				int count = getCount(32374789) + 1;
				incrCount(32374789);
				iristk.situated.SystemAgentFlow.say state9 = agent.new say();
				state9.setText("What is your guess?");
				if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 45, 12)))) {
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				iristk.situated.SystemAgentFlow.listen state10 = agent.new listen();
				if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 45, 12)))) {
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			}
		}

		@Override
		public int onFlowEvent(Event event) {
			int eventResult;
			int count;
			count = getCount(1973538135) + 1;
			if (event.triggers("sense.user.speak")) {
				if (event.has("sem:number")) {
					incrCount(1973538135);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						if (system.isAttendingAll()) {
							iristk.situated.SystemAgentFlow.attend state11 = agent.new attend();
							state11.setTarget(event.get("user"));
							if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 50, 39)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						system.getCurrentUser().incrInteger("guesses");
						if (asInteger(event.get("sem:number")) == number) {
							iristk.situated.SystemAgentFlow.say state12 = agent.new say();
							state12.setText(concat(event.get("sem:number"), "is correct, you only needed", system.getCurrentUser().get("guesses"), "guesses."));
							if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 54, 53)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							CheckAgain state13 = new CheckAgain();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 61, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						} else {
							if (asInteger(event.get("sem:number")) > number) {
								iristk.situated.SystemAgentFlow.say state14 = agent.new say();
								state14.setText(concat(event.get("sem:number"), "is too high."));
								if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 63, 56)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							} else {
								iristk.situated.SystemAgentFlow.say state15 = agent.new say();
								state15.setText(concat(event.get("sem:number"), "is too low."));
								if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 63, 56)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
							if (system.hasManyUsers()) {
								boolean chosen16 = false;
								boolean matching17 = true;
								while (!chosen16 && matching17) {
									int rand18 = random(212628335, 2, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
									matching17 = false;
									if (true) {
										matching17 = true;
										if (rand18 >= 0 && rand18 < 1) {
											chosen16 = true;
											iristk.situated.SystemAgentFlow.attendOther state19 = agent.new attendOther();
											if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 69, 14)))) {
												eventResult = EVENT_ABORTED;
												break EXECUTION;
											}
										}
									}
									if (true) {
										matching17 = true;
										if (rand18 >= 1 && rand18 < 2) {
											chosen16 = true;
											iristk.situated.SystemAgentFlow.attendAll state20 = agent.new attendAll();
											if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 69, 14)))) {
												eventResult = EVENT_ABORTED;
												break EXECUTION;
											}
										}
									}
								}
							}
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 74, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() {
			int eventResult;
			Event event = new Event("state.enter");
			EXECUTION: {
				int count = getCount(2111991224) + 1;
				incrCount(2111991224);
				iristk.situated.SystemAgentFlow.say state21 = agent.new say();
				state21.setText("Do you want to play again?");
				if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 80, 12)))) {
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				iristk.situated.SystemAgentFlow.listen state22 = agent.new listen();
				if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 80, 12)))) {
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			}
		}

		@Override
		public int onFlowEvent(Event event) {
			int eventResult;
			int count;
			count = getCount(917142466) + 1;
			if (event.triggers("sense.user.speak")) {
				if (event.has("sem:yes")) {
					incrCount(917142466);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state23 = agent.new say();
						state23.setText("Okay, let's play again.");
						if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 84, 58)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						Start state24 = new Start();
						flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 86, 25)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			}
			count = getCount(653305407) + 1;
			if (event.triggers("sense.user.speak")) {
				if (event.has("sem:no")) {
					incrCount(653305407);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state25 = agent.new say();
						state25.setText("Okay, goodbye");
						if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 88, 57)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						Idle state26 = new Idle();
						flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 90, 24)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) {
			int eventResult;
			int count;
			count = getCount(604107971) + 1;
			if (event.triggers("sense.user.speech.start")) {
				if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
					incrCount(604107971);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						Event sendEvent27 = new Event("action.gesture");
						sendEvent27.putIfNotNull("name", "smile");
						flowRunner.sendEvent(sendEvent27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 96, 51)));
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			}
			count = getCount(1227229563) + 1;
			if (event.triggers("sense.user.speak")) {
				incrCount(1227229563);
				eventResult = EVENT_CONSUMED;
				EXECUTION: {
					iristk.situated.SystemAgentFlow.say state28 = agent.new say();
					state28.setText("Sorry, I didn't get that.");
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 98, 36)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 100, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				if (eventResult != EVENT_IGNORED) return eventResult;
			}
			count = getCount(1562557367) + 1;
			if (event.triggers("sense.user.speak.side")) {
				incrCount(1562557367);
				eventResult = EVENT_CONSUMED;
				EXECUTION: {
					iristk.situated.SystemAgentFlow.attendOther state29 = agent.new attendOther();
					state29.setMode("eyes");
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 102, 41)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state30 = agent.new say();
					state30.setText("I didn't ask you.");
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 102, 41)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.attendOther state31 = agent.new attendOther();
					state31.setMode("eyes");
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 102, 41)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 106, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				if (eventResult != EVENT_IGNORED) return eventResult;
			}
			count = getCount(942731712) + 1;
			if (event.triggers("sense.user.speak.multi")) {
				incrCount(942731712);
				eventResult = EVENT_CONSUMED;
				EXECUTION: {
					iristk.situated.SystemAgentFlow.say state32 = agent.new say();
					state32.setText("Don't speak at the same time.");
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 108, 42)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 110, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				if (eventResult != EVENT_IGNORED) return eventResult;
			}
			count = getCount(1910163204) + 1;
			if (event.triggers("sense.user.silence")) {
				incrCount(1910163204);
				eventResult = EVENT_CONSUMED;
				EXECUTION: {
					iristk.situated.SystemAgentFlow.say state33 = agent.new say();
					state33.setText("Sorry, I didn't hear anything.");
					if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 112, 38)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 114, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				if (eventResult != EVENT_IGNORED) return eventResult;
			}
			count = getCount(758529971) + 1;
			if (event.triggers("sense.user.leave")) {
				if (system.isAttending(event)) {
					incrCount(758529971);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						if (system.hasUsers()) {
							iristk.situated.SystemAgentFlow.attendRandom state34 = agent.new attendRandom();
							if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 117, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							Guess state35 = new Guess();
							flowThread.gotoState(state35, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 119, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						} else {
							Idle state36 = new Idle();
							flowThread.gotoState(state36, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 121, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			}
			count = getCount(1763847188) + 1;
			if (event.triggers("repeat")) {
				incrCount(1763847188);
				eventResult = EVENT_CONSUMED;
				EXECUTION: {
					flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Dropbox\\iristk\\app\\interaction\\src\\iristk\\app\\interaction\\InteractionFlow.xml"), 125, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
				if (eventResult != EVENT_IGNORED) return eventResult;
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
