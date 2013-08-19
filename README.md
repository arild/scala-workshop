
### Introduksjon til Scala og Futures & Promises

Scala er et funksjonelt programmeringsspråk som kjøer på JVM'en

Futures & Promises er asynkrone primitiver for å uttrykke parallellitet.

Denne workshopen vil gi en introduksjon til Scala via noen slides og hands-on oppgaver, før Futures & Promises introduseres.

Før 5. september er det noen ting som bør være installert og satt opp:

1. Installerer Scala 2.10.x (http://www.scala-lang.org/downloads)
2. Installerer sbt 0.12.4 (http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html)
3. Installerer Scala-plugin i sitt IDE
       * Eclipse:
              http://scala-ide.org/download/milestone.html#scala_ide_21_milestone_3
              Update sites er litt nede på siden. Velg site for Scala 2.10, og for den versjonen av Eclipse du bruker.
       * IDEA IntelliJ:
              http://confluence.jetbrains.com/display/SCA/Scala+Plugin+for+IntelliJ+IDEA
4. Installerer git
5. Henter ned prosjektet : `git clone https://github.com/arild/fagdag_mar2013.git`
6. Eksekverer `sbt` fra mappen 'fagdag_mar2013', og skriver enten `eclipse` eller `gen-idea` (avhengig av IDE)
7. Åpne prosjektet i Eclipse eller IntelliJ
8. Se at tester kjører: eksekverer `sbt test` fra mappen 'fagdag_mar2013'.

Ved problemer med oppsettet, send en mail til arild.nilsen (at) bekk.no eller sjur.millidahl (at) bekk.no kontaktes
