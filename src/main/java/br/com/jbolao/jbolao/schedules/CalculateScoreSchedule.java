package br.com.jbolao.jbolao.schedules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.jbolao.jbolao.models.Campeonato;
import br.com.jbolao.jbolao.services.CampeonatoService;

@Component
@EnableScheduling
public class CalculateScoreSchedule {

	private static final Logger logger = LoggerFactory.getLogger(CalculateScoreSchedule.class);

	@Autowired
	private CampeonatoService campeonatoService;
	
	@Scheduled(fixedRate = 600000) // 10 min
	public synchronized void execute() {
		logger.info("execute()... " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
		List<Campeonato> list = this.campeonatoService.findForCalc();
		for (Campeonato campeonato : list) {
			logger.info("Calculating... = " + campeonato);
			this.campeonatoService.calcular(campeonato);
		}
	}
	
}
