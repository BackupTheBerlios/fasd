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
<xsl:variable name="why1Lbl">Warum haben Sie sich bei dieser Frage für den Wert "</xsl:variable>
<xsl:variable name="why2Lbl">" entschieden?</xsl:variable>
<xsl:variable name="ownLbl">Wie haben Sie diese Aussage verstanden? Bitte geben Sie eine eigene Formulierung.</xsl:variable>
<xsl:variable name="understandLbl">Gibt es etwas, das Sie bei dieser Frage nicht verstanden haben?</xsl:variable>
<xsl:variable name="guessLbl">Was würden Sie sagen: Ist Ihre Angabe sehr genau, ziemlich genau, eher ungenau oder grob geschätzt?</xsl:variable>
<xsl:variable name="difficultLbl">Wie schwer fiel es Ihnen, diese Frage zu beantworten?</xsl:variable>

<xsl:variable name="TitleLbl">Pretest FASD Survey: "Spass und Software-Entwicklung"</xsl:variable>
<xsl:variable name="RemarkLbl"><b>Fragen zum FASD-Fragebogen:</b> Dies ist der eigentliche Pretest. Bitte füllen Sie diesen Teil möglichst genau aus. Damit können Sie uns helfen, die Qualität der geplanten Umfrage zu steigern.</xsl:variable>
<xsl:variable name="q1Lbl">Ich habe kein Gefühl mehr dafür, wie lange ich schon bei dieser Tätigkeit bin.</xsl:variable>
<xsl:variable name="q1pre_Lbl">Was heisst das genau für Sie, wenn Sie kein Gefühl mehr dafür haben, wie lange Sie bei einer Tätigkeit sind? Welche Merkmale charakterisieren einen solchen Zustand?</xsl:variable>
<xsl:variable name="q3Lbl">Die Handlung erfolgt wie aus einem Guss.</xsl:variable>
<xsl:variable name="q3pre_Lbl">Was heisst das genau für Sie, wenn die Handlung wie aus einem Guss erfolgt? Wie ist ein solche Situation gekennzeichnet?</xsl:variable>
<xsl:variable name="q5Lbl">Es fällt mir leicht, mich zu konzentrieren.</xsl:variable>
<xsl:variable name="q6Lbl">Ich gehe ganz in der Handlung auf.</xsl:variable>
<xsl:variable name="q6pre_Lbl">Was heisst das genau für Sie, wenn Sie vollständig in der Handlung aufgehen?</xsl:variable>
<xsl:variable name="q8Lbl">In der Situation sind die Anforderungen an mich völlig klar.</xsl:variable>
<xsl:variable name="q10Lbl">Die Anforderungen an mich sind eindeutig.</xsl:variable>
<xsl:variable name="q10pre_Lbl">Erkennen Sie einen Unterschied zwischen diesen beiden Fragen?</xsl:variable>
<xsl:variable name="q11Lbl">Es gibt viele Dinge, die ich lieber tun würde.</xsl:variable>
<xsl:variable name="q13Lbl">Ich handle nur, weil ich weiss, dass es sich für mich lohnen wird.</xsl:variable>
<xsl:variable name="q13pre_Lbl">Was heisst das genau für Sie, nur zu handeln, wenn es sich für Sie lohnt? Empfinden Sie eine Aktivität als lohnend, wenn sie sich finanziell auszahlt, oder würden Sie auch andere Folgen der Aktivität als lohnend bezeichnen? Wenn letzteres zutrifft: was für Folgen sind in diesem Sinn für Sie lohnend?</xsl:variable>
<xsl:variable name="q21Lbl">Ich freue mich schon vorher auf die Handlung.</xsl:variable>
<xsl:variable name="q29Lbl">Ich freue mich auf weitere Entwicklungstätigkeiten für Open Source-Software.</xsl:variable>
<xsl:variable name="q30Lbl">Ich bin bereit, mein zukünftiges Engagement bei der Entwicklung von Open Source-Software zu vergrössern.</xsl:variable>
<xsl:variable name="q31Lbl">Wie oft sind die Open Source-Projekte, an denen Sie sich beteiligen, von einer klaren Projektvision getragen?</xsl:variable>
<xsl:variable name="q31pre_Lbl">Was heisst das genau für Sie, wenn ein Projekt von einer klaren Projektvision getragen ist? Was ist in Ihren Augen eine Projektvision und wie kann sich eine solche auf das Projekt auswirken?</xsl:variable>
<xsl:variable name="q33Lbl">Wie wichtig ist die Vision hinter einem Open Source-Projekt für Ihre Projektbeteiligung?</xsl:variable>
<xsl:variable name="q35Lbl"><i>Als Projektmitglied:</i> Aus welchen Gründen beteiligten Sie sich an Open Source-Projekten?</xsl:variable>
<xsl:variable name="q35aLbl">Ich benötigte (für meine Arbeit) eine bestimmte Funktionalität und bin so auf das Open Source-Projekt gestossen und habe mich darin engagiert.</xsl:variable>
<xsl:variable name="q35bLbl">Mein Arbeitgeber beauftragte mich, am Open Source-Projekt mitzuarbeiten, weil er die Funktionalität benötigte.</xsl:variable>
<xsl:variable name="q35cLbl">Weil ich etwas für die Open Source-Community machen wollte.</xsl:variable>
<xsl:variable name="q35dLbl">Das Projekt versprach, Spass zu machen.</xsl:variable>
<xsl:variable name="q35eLbl">Kollegen haben mich dazu motiviert, am Open Source-Projekt mitzuarbeiten.</xsl:variable>
<xsl:variable name="q35fLbl">Durch die Beteiligung am Open Source-Projekt konnte man berühmt werden.</xsl:variable>
<xsl:variable name="q35fpre_Lbl">Was heisst das genau in Ihren Augen, durch Mitwirken an einem Open Source-Projekt berühmt zu werden?</xsl:variable>
<xsl:variable name="q35gLbl">Weil ich neue Fähigkeiten erwerben und entwickeln wollte.</xsl:variable>
<xsl:variable name="q36Lbl"><i>Als Projektverantwortlicher:</i> Aus welchen Gründen initiierten Sie Ihre Open Source-Projekte?</xsl:variable>
<xsl:variable name="q36aLbl">Ich benötigte (für meine Arbeit) eine bestimmte Funktionalität und wollte diese in der Form einer Open Source-Applikation zur Verfügung stellen.</xsl:variable>
<xsl:variable name="q36bLbl">Mein Arbeitgeber beauftragte mich, das Open Source-Projekt zu starten, weil er die Funktionalität benötigte.</xsl:variable>
<xsl:variable name="q36cLbl">Mein Arbeitgeber beauftragte mich, das Open Source-Projekt zu starten, weil er mit der Applikation Geld verdienen konnte.</xsl:variable>
<xsl:variable name="q36dLbl">Weil ich etwas für die Open Source-Community machen wollte.</xsl:variable>
<xsl:variable name="q36eLbl">Ein älteres Open Source-Projekt hat sich nicht in gewünschter Weise entwickelt und so musste ich ein eigenes starten.</xsl:variable>
<xsl:variable name="q36fLbl">Das Projekt versprach, Spass zu machen.</xsl:variable>
<xsl:variable name="q36gLbl">Ich benötigte Helfer, um ein Software-Projekt fertigstellen zu können.</xsl:variable>
<xsl:variable name="q36hLbl">Mit einem Open Source-Projekt konnte man berühmt werden.</xsl:variable>
<xsl:variable name="q36pre2_Lbl">Gibt es in Ihren Augen relevante Motive, die in dieser Liste fehlen?</xsl:variable>
<xsl:variable name="q37Lbl">Wie viele Patches/Klassen haben Sie für Open Source-Software geschrieben?</xsl:variable>
<xsl:variable name="q37pre_Lbl">Was heisst das genau für Sie, einen Patch oder eine Klasse zu schreiben? Finden Sie die Frage nach den implementierten Patches/Klassen ein sinnvolles Mass zur Messung der Aktivität?</xsl:variable>
<xsl:variable name="q38Lbl">Bitte schätzen Sie die Zeit, die sie aktuell für die Entwicklung von Open Source-Software aufwenden (durchschnittliche Stunden pro Woche)</xsl:variable>
<xsl:variable name="q39Lbl">Von der Zeit insgesamt, die Sie für die Entwicklung von Open Source-Software verwenden, wie viel Prozent entwickeln Sie in Ihrer Freizeit?</xsl:variable>
<xsl:variable name="q40Lbl">Wie viel Prozent Ihrer Freizeit verwenden Sie für Arbeiten in Open Source-Projekten (im Durchschnitt)?</xsl:variable>
<xsl:variable name="q41Lbl">Von der Zeit insgesamt, die Sie für die Entwicklung von Open Source-Software verwenden, wie viel Prozent davon werden Sie für diese Arbeit bezahlt?</xsl:variable>
<xsl:variable name="q41pre_Lbl">Wie sehen Sie den Bezug zu Frage 39?</xsl:variable>
<xsl:variable name="q46Lbl">Leben in Ihrem Haushalt weitere erwachsene Personen?</xsl:variable>
<xsl:variable name="q47Lbl">Mit wie vielen Hobbies (inklusive Programmieren) beschäftigen Sie sich regelmässig?</xsl:variable>
<xsl:variable name="q47pre_Lbl">Was heisst das genau für Sie, ein regelmässiges Hobby zu betreiben? Was sind für Sie regelmässige Hobbies und was verstehen Sie in diesem Zusammenhang unter regelmässig?</xsl:variable>
<xsl:variable name="finishLbl">Zum Abschluss:</xsl:variable>
<xsl:variable name="pre1Lbl">Wie empfinden Sie die Länge des Fragebogens (gut, akzeptabel, zu lang, zu kurz)?</xsl:variable>
<xsl:variable name="pre2Lbl">Wie beurteilen Sie die Verständlichkeit der Fragen?</xsl:variable>
<xsl:variable name="pre3Lbl">Gibt es Fragen, die Sie als heikel empfinden, im Sinne einer möglichen Verletzung Ihrer Privatsphäre?</xsl:variable>
<xsl:variable name="pre4Lbl">Wie beurteilen Sie die Gestaltung und Handhabung des Fragebogens?</xsl:variable>

<!-- include the language independent xsl for the View -->
<xsl:include href="../../shared/pre/pretest.xsl"/>

</xsl:stylesheet>
