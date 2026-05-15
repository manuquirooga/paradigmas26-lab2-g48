// =====================================================================
// Ejercicio 6: Integración del sistema completo
// =====================================================================

object Main {
  def main(args: Array[String]): Unit = {

    // 1. Cargar diccionarios (Ejercicio 2)
    val dictionary: List[NamedEntity] = Dictionary.loadAll()
    println(s"Diccionario cargado: ${dictionary.size} entidades.\n")

    // ------------------------------------------------------------------
    // Paso 1: Cargar diccionarios
    // ------------------------------------------------------------------
    // TODO (Ejercicio 2)
    val subscriptions = FileIO.readSubscriptions()
    val allPosts: List[(String, List[String])] = subscriptions.map { url =>
      println(s"Descargando posts de: $url")
      val json   = FileIO.downloadFeed(url)
      val titles = FileIO.extractPostTitles(json)
      (url, titles)
    }

    val allDetected: List[NamedEntity] = allPosts.flatMap { case (url, titles) =>
      titles.flatMap { title =>
        val detected = Analyzer.detectEntities(title, dictionary)
        
        if (detected.nonEmpty) {
            println(Formatters.formatNERResult(title, detected))
        }
        
        detected 
      }
    }

    val stats = Analyzer.countByType(allDetected)
    println(Formatters.formatEntityStats(stats))


    // --- PUNTO ESTRELLA ---
    val statsJerarquicas = Analyzer.jerarquia(allDetected)
    // Mostramos los resultados con un poquito de "sangría" (espacios) para que quede lindo
    println("\n=== Estadísticas Jerárquicas ===")
    println(s"Technology: ${statsJerarquicas.getOrElse("Technology", 0)}")
    println(s"ProgrammingLanguage: ${statsJerarquicas.getOrElse("ProgrammingLanguage", 0)}")
    println(s"Organization: ${statsJerarquicas.getOrElse("Organization", 0)}")
    println(s"University: ${statsJerarquicas.getOrElse("University", 0)}")
    println(s"Person: ${statsJerarquicas.getOrElse("Person", 0)}")

  } 
}