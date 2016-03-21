package iristk.app.interaction;

import iristk.cfg.SRGSGrammar;
import iristk.flow.Flow;
import iristk.situated.Skill;
import iristk.situated.SkillRequirements;
import iristk.speech.SpeechGrammarContext;
import iristk.util.Language;

public class InteractionSkill extends Skill {

	@Override
	public Flow init() throws Exception {
		loadContext("default", new SpeechGrammarContext(new SRGSGrammar(getClass().getResource("InteractionGrammar.xml").toURI())));
		setDefaultContext("default");
		return new InteractionFlow(getSystemAgentFlow());
	}

	@Override
	public String getName() {
		return "Interaction";
	}

	@Override
	public SkillRequirements getRequirements() {
		SkillRequirements requirements = super.getRequirements();
		requirements.requireLanguage(Language.ENGLISH_US);
		requirements.requireSpeechGrammar(true);
		return requirements;
	}
}
