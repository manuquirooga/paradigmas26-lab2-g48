// =====================================================================
// Ejercicio 6: Integración del sistema completo
// =====================================================================

object Main {
  def main(args: Array[String]): Unit = {

    // ------------------------------------------------------------------
    // Paso 1: Cargar diccionarios
    // ------------------------------------------------------------------
    // TODO (Ejercicio 2)
    val dictionary: List[NamedEntity] = ???

    println(s"Diccionario cargado: ${dictionary.size} entidades.\n")

    // ------------------------------------------------------------------
    // Paso 2: Descargar posts
    // ------------------------------------------------------------------
    val subscriptions = FileIO.readSubscriptions()

    val allPosts: List[(String, List[String])] = subscriptions.map { url =>
      println(s"Descargando posts de: $url")
      val json   = FileIO.downloadFeed(url)
      val titles = FileIO.extractPostTitles(json)
      (url, titles)
    }

    // ------------------------------------------------------------------
    // Paso 3: Detectar entidades y mostrar resultados por post
    // ------------------------------------------------------------------
    // TODO (Ejercicios 3, 4 y 6):
    //   Para cada post:
    //     1. Detectar entidades
    //     2. Formatear y mostrar el resultado

    // ------------------------------------------------------------------
    // Paso 4: Estadísticas globales
    // ------------------------------------------------------------------
    // TODO (Ejercicios 5 y 6):
    //   1. Recolectar TODAS las entidades detectadas en todos los posts
    //   2. Contar por tipo
    //   3. Mostrar el resumen

  }


   // --- PUNTO ESTRELLA ---
    val statsJerarquicas = Analyzer.jerarquia(allDetected)

    println("\n=== Estadísticas Jerárquicas ===")
    // Mostramos los resultados con un poquito de "sangría" (espacios) para que quede lindo
    println(s"Technology: ${statsJerarquicas.getOrElse("Technology", 0)}")
    println(s"ProgrammingLanguage: ${statsJerarquicas.getOrElse("ProgrammingLanguage", 0)}")
    println(s"Organization: ${statsJerarquicas.getOrElse("Organization", 0)}")
    println(s"University: ${statsJerarquicas.getOrElse("University", 0)}")
    println(s"Person: ${statsJerarquicas.getOrElse("Person", 0)}")
}

