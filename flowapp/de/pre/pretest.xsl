<?xml version="1.0" encoding="ISO-8859-1"?>

<!-- 	(c) GNU General Public License
	Author: Benno Luthiger, Aktion HIP, Switzerland
-->

<!-- 
	Defining some language dependent variables, used in view
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:variable name="dontKnow">weiss nicht</xsl:variable>
<xsl:variable name="ButtonLbl">Speichern</xsl:variable>
<xsl:variable name="hoursLbl">Stunden</xsl:variable>
<xsl:variable name="why1Lbl">Warum haben Sie sich bei dieser Frage f�r den Wert "</xsl:variable>
<xsl:variable name="why2Lbl">" entschieden?</xsl:variable>
<xsl:variable name="ownLbl">Wie haben Sie diese Aussage verstanden? Bitte geben Sie eine eigene Formulierung.</xsl:variable>
<xsl:variable name="understandLbl">Gibt es etwas, das Sie bei dieser Frage nicht verstanden haben?</xsl:variable>
<xsl:variable name="guessLbl">Was w�rden Sie sagen: Ist Ihre Angabe sehr genau, ziemlich genau, eher ungenau oder grob gesch�tzt?</xsl:variable>
<xsl:variable name="difficultLbl">Wie schwer fiel es Ihnen, diese Frage zu beantworten?</xsl:variable>

<xsl:variable name="TitleLbl">Pretest FASD Survey: "Spass und Software-Entwicklung"</xsl:variable>
<xsl:variable name="RemarkLbl"><b>Fragen zum FASD-Fragebogen:</b> Dies ist der eigentliche Pretest. Bitte f�llen Sie diesen Teil m�glichst genau aus. Damit k�nnen Sie uns helfen, die Qualit�t der geplanten Umfrage zu steigern.</xsl:variable>
<xsl:variable name="q1Lbl">Ich habe kein Gef�hl mehr daf�r, wie lange ich schon bei dieser T�tigkeit bin.</xsl:variable>
<xsl:variable name="q1pre_Lbl">Was heisst das genau f�r Sie, wenn Sie kein Gef�hl mehr daf�r haben, wie lange Sie bei einer T�tigkeit sind? Welche Merkmale charakterisieren einen solchen Zustand?</xsl:variable>
<xsl:variable name="q3Lbl">Die Handlung erfolgt wie aus einem Guss.</xsl:variable>
<xsl:variable name="q3pre_Lbl">Was heisst das genau f�r Sie, wenn die Handlung wie aus einem Guss erfolgt? Wie ist ein solche Situation gekennzeichnet?</xsl:variable>
<xsl:variable name="q5Lbl">Es f�llt mir leicht, mich zu konzentrieren.</xsl:variable>
<xsl:variable name="q6Lbl">Ich gehe ganz in der Handlung auf.</xsl:variable>
<xsl:variable name="q6pre_Lbl">Was heisst das genau f�r Sie, wenn Sie vollst�ndig in der Handlung aufgehen?</xsl:variable>
<xsl:variable name="q8Lbl">In der Situation sind die Anforderungen an mich v�llig klar.</xsl:variable>
<xsl:variable name="q10Lbl">Die Anforderungen an mich sind eindeutig.</xsl:variable>
<xsl:variable name="q10pre_Lbl">Erkennen Sie einen Unterschied zwischen diesen beiden Fragen?</xsl:variable>
<xsl:variable name="q11Lbl">Es gibt viele Dinge, die ich lieber tun w�rde.</xsl:variable>
<xsl:variable name="q13Lbl">Ich handle nur, weil ich weiss, dass es sich f�r mich lohnen wird.</xsl:variable>
<xsl:variable name="q13pre_Lbl">Was heisst das genau f�r Sie, nur zu handeln, wenn es sich f�r Sie lohnt? Empfinden Sie eine Aktivit�t als lohnend, wenn sie sich finanziell auszahlt, oder w�rden Sie auch andere Folgen der Aktivit�t als lohnend bezeichnen? Wenn letzteres zutrifft: was f�r Folgen sind in diesem Sinn f�r Sie lohnend?</xsl:variable>
<xsl:variable name="q21Lbl">Ich freue mich schon vorher auf die Handlung.</xsl:variable>
<xsl:variable name="q29Lbl">Ich freue mich auf weitere Entwicklungst�tigkeiten f�r Open Source-Software.</xsl:variable>
<xsl:variable name="q30Lbl">Ich bin bereit, mein zuk�nftiges Engagement bei der Entwicklung von Open Source-Software zu vergr�ssern.</xsl:variable>
<xsl:variable name="q31Lbl">Wie oft sind die Open Source-Projekte, an denen Sie sich beteiligen, von einer klaren Projektvision getragen?</xsl:variable>
<xsl:variable name="q31pre_Lbl">Was heisst das genau f�r Sie, wenn ein Projekt von einer klaren Projektvision getragen ist? Was ist in Ihren Augen eine Projektvision und wie kann sich eine solche auf das Projekt auswirken?</xsl:variable>
<xsl:variable name="q33Lbl">Wie wichtig ist die Vision hinter einem Open Source-Projekt f�r Ihre Projektbeteiligung?</xsl:variable>
<xsl:variable name="q35Lbl"><i>Als Projektmitglied:</i> Aus welchen Gr�nden beteiligten Sie sich an Open Source-Projekten?</xsl:variable>
<xsl:variable name="q35aLbl">Ich ben�tigte (f�r meine Arbeit) eine bestimmte Funktionalit�t und bin so auf das Open Source-Projekt gestossen und habe mich darin engagiert.</xsl:variable>
<xsl:variable name="q35bLbl">Mein Arbeitgeber beauftragte mich, am Open Source-Projekt mitzuarbeiten, weil er die Funktionalit�t ben�tigte.</xsl:variable>
<xsl:variable name="q35cLbl">Weil ich etwas f�r die Open Source-Community machen wollte.</xsl:variable>
<xsl:variable name="q35dLbl">Das Projekt versprach, Spass zu machen.</xsl:variable>
<xsl:variable name="q35eLbl">Kollegen haben mich dazu motiviert, am Open Source-Projekt mitzuarbeiten.</xsl:variable>
<xsl:variable name="q35fLbl">Durch die Beteiligung am Open Source-Projekt konnte man ber�hmt werden.</xsl:variable>
<xsl:variable name="q35fpre_Lbl">Was heisst das genau in Ihren Augen, durch Mitwirken an einem Open Source-Projekt ber�hmt zu werden?</xsl:variable>
<xsl:variable name="q35gLbl">Weil ich neue F�higkeiten erwerben und entwickeln wollte.</xsl:variable>
<xsl:variable name="q36Lbl"><i>Als Projektverantwortlicher:</i> Aus welchen Gr�nden initiierten Sie Ihre Open Source-Projekte?</xsl:variable>
<xsl:variable name="q36aLbl">Ich ben�tigte (f�r meine Arbeit) eine bestimmte Funktionalit�t und wollte diese in der Form einer Open Source-Applikation zur Verf�gung stellen.</xsl:variable>
<xsl:variable name="q36bLbl">Mein Arbeitgeber beauftragte mich, das Open Source-Projekt zu starten, weil er die Funktionalit�t ben�tigte.</xsl:variable>
<xsl:variable name="q36cLbl">Mein Arbeitgeber beauftragte mich, das Open Source-Projekt zu starten, weil er mit der Applikation Geld verdienen konnte.</xsl:variable>
<xsl:variable name="q36dLbl">Weil ich etwas f�r die Open Source-Community machen wollte.</xsl:variable>
<xsl:variable name="q36eLbl">Ein �lteres Open Source-Projekt hat sich nicht in gew�nschter Weise entwickelt und so musste ich ein eigenes starten.</xsl:variable>
<xsl:variable name="q36fLbl">Das Projekt versprach, Spass zu machen.</xsl:variable>
<xsl:variable name="q36gLbl">Ich ben�tigte Helfer, um ein Software-Projekt fertigstellen zu k�nnen.</xsl:variable>
<xsl:variable name="q36hLbl">Mit einem Open Source-Projekt konnte man ber�hmt werden.</xsl:variable>
<xsl:variable name="q36pre2_Lbl">Gibt es in Ihren Augen relevante Motive, die in dieser Liste fehlen?</xsl:variable>
<xsl:variable name="q37Lbl">Wie viele Patches/Klassen haben Sie f�r Open Source-Software geschrieben?</xsl:variable>
<xsl:variable name="q37pre_Lbl">Was heisst das genau f�r Sie, einen Patch oder eine Klasse zu schreiben? Finden Sie die Frage nach den implementierten Patches/Klassen ein sinnvolles Mass zur Messung der Aktivit�t?</xsl:variable>
<xsl:variable name="q38Lbl">Bitte sch�tzen Sie die Zeit, die sie aktuell f�r die Entwicklung von Open Source-Software aufwenden (durchschnittliche Stunden pro Woche)</xsl:variable>
<xsl:variable name="q39Lbl">Von der Zeit insgesamt, die Sie f�r die Entwicklung von Open Source-Software verwenden, wie viel Prozent entwickeln Sie in Ihrer Freizeit?</xsl:variable>
<xsl:variable name="q40Lbl">Wie viel Prozent Ihrer Freizeit verwenden Sie f�r Arbeiten in Open Source-Projekten (im Durchschnitt)?</xsl:variable>
<xsl:variable name="q41Lbl">Von der Zeit insgesamt, die Sie f�r die Entwicklung von Open Source-Software verwenden, wie viel Prozent davon werden Sie f�r diese Arbeit bezahlt?</xsl:variable>
<xsl:variable name="q41pre_Lbl">Wie sehen Sie den Bezug zu Frage 39?</xsl:variable>
<xsl:variable name="q46Lbl">Leben in Ihrem Haushalt weitere erwachsene Personen?</xsl:variable>
<xsl:variable name="q47Lbl">Mit wie vielen Hobbies (inklusive Programmieren) besch�ftigen Sie sich regelm�ssig?</xsl:variable>
<xsl:variable name="q47pre_Lbl">Was heisst das genau f�r Sie, ein regelm�ssiges Hobby zu betreiben? Was sind f�r Sie regelm�ssige Hobbies und was verstehen Sie in diesem Zusammenhang unter regelm�ssig?</xsl:variable>
<xsl:variable name="finishLbl">Zum Abschluss:</xsl:variable>
<xsl:variable name="pre1Lbl">Wie empfinden Sie die L�nge des Fragebogens (gut, akzeptabel, zu lang, zu kurz)?</xsl:variable>
<xsl:variable name="pre2Lbl">Wie beurteilen Sie die Verst�ndlichkeit der Fragen?</xsl:variable>
<xsl:variable name="pre3Lbl">Gibt es Fragen, die Sie als heikel empfinden, im Sinne einer m�glichen Verletzung Ihrer Privatsph�re?</xsl:variable>
<xsl:variable name="pre4Lbl">Wie beurteilen Sie die Gestaltung und Handhabung des Fragebogens?</xsl:variable>

<!-- include the language independent xsl for the View -->
<xsl:include href="../../shared/pre/pretest.xsl"/>

</xsl:stylesheet>
