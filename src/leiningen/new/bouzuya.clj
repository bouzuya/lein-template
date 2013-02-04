(ns leiningen.new.bouzuya
  (:use [leiningen.new.templates :only [renderer name-to-path ->files year multi-segment project-name sanitize-ns]]))

(defn bouzuya
  "A Leiningen template for bouzuya's library"
  [name]
  (let [render (renderer "bouzuya")
        data {:raw-name name
              :name (project-name name)
              :path (name-to-path (project-name name))
              :namespace (sanitize-ns (project-name name))
              :year (year)}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/{{path}}.clj" (render "src.clj" data)]
             ["test/{{path}}_test.clj" (render "test.clj" data)]
             ["README.md" (render "README.md" data)])))

